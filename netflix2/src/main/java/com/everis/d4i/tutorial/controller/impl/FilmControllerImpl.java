package com.everis.d4i.tutorial.controller.impl;

import com.everis.d4i.tutorial.controller.FilmController;
import com.everis.d4i.tutorial.controller.mapper.FilmRestMapper;
import com.everis.d4i.tutorial.exception.NetflixException;
import com.everis.d4i.tutorial.controller.rest.FilmRest;
import com.everis.d4i.tutorial.controller.rest.response.NetflixResponse;
import com.everis.d4i.tutorial.service.FilmService;
import com.everis.d4i.tutorial.util.constant.CommonConstants;
import com.everis.d4i.tutorial.util.constant.RestConstants;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1)
@RequiredArgsConstructor
public class FilmControllerImpl implements FilmController {

    @Autowired
    private FilmService filmService;
    // SORTING
    /*
    @Override
    @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
            value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<List<FilmRest>> getFilms(
            @ApiParam
            @ApiIgnore("default params not useful. Using ApiImplicitParam instead")
            @SortDefault(value = "year", direction = Sort.Direction.ASC) final Sort sort) {
        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                filmService.getFilmsByCategorySortedDynamically(sort));
    }
*/
    
    // PAGINATION

    @Override
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)", defaultValue = "0"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of entries per page.", defaultValue = "8"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                                    "Default sort order is ascending. " +
                                    "Multiple sort criteria are supported.")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public NetflixResponse<Slice<FilmRest>> getFilms(
            @ApiIgnore("ignored because too much stuff. Selection done instead with ApiImplicitParams")
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 8) final Pageable pageable) {
        return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
                filmService.getPageOfFilms(pageable));
    }
    
    //FILTERING STATIC
}
