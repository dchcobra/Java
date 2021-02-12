package com.everis.d4i.tutorial.controller.impl;

import com.everis.d4i.tutorial.controller.FilmController;
import com.everis.d4i.tutorial.controller.mapper.FilmRestMapper;
import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.controller.rest.FilteringParameters;
import com.everis.d4i.tutorial.controller.rest.response.NetflixResponse;
import com.everis.d4i.tutorial.service.FilmService;
import com.everis.d4i.tutorial.util.constant.CommonConstants;
import com.everis.d4i.tutorial.util.constant.RestConstants;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1)
@RequiredArgsConstructor
public class FilmControllerImpl implements FilmController {

    @Autowired
    private FilmService filmService;
    
	private final FilmRestMapper filmRestMapper;


    @Override
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of entries per page.", defaultValue = "8"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property,(asc|desc). " +
                                    "Default sort order is ascending. " +
                                    "Multiple sort criteria are supported.")
    })
    
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_FILM, produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<Slice<FilmRest>> getFilms(
            @ApiIgnore("ignored because too much stuff. Selection done instead with ApiImplicitParams")
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 8) final Pageable pageable) {
    	return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                filmService.getPageOfFilms(pageable).map(filmRestMapper::mapToRest));
        
    }

    //FILTERING STATIC

	@Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_FILM_STATIC_FILTER, produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<FilmRest[]> getFilmsFilteredStatic(
    		@RequestParam(name = "minimumDuration", required = false) final Integer minimumDuration) {

    	return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                filmService.getFilmsFilteredByMinimumDuration(minimumDuration).parallelStream().map(filmRestMapper::mapToRest).toArray(FilmRest[]::new));
		}

    // DINAMIC FILTERING

	@Override
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = RestConstants.RESOURCE_FILM_DINAMIC_FILTER, produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<FilmRest[]> getFilmsFilteredDynamic(
            @RequestParam(name = "name", required = false) final String name,
            @RequestParam(name = "year", required = false) final Year year) {

        FilteringParameters filters = FilteringParameters.builder()
                                              .name(name)
                                              .year(year)
                                              .build();

        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                filmService.getDynamicallyFiltered(filters).stream().map(filmRestMapper::mapToRest).toArray(FilmRest[]::new));

    }

    
}
