/* BASIC
INSERT INTO course(id, name) VALUES (10001, 'JDBC to JPA');
INSERT INTO course(id, name) VALUES (10002, 'Spring');
INSERT INTO course(id, name) VALUES (10003, 'JPA');
*/
/* STEP 16 - CHAPTER 5
INSERT INTO course_details(id, name) VALUES (10001, 'JDBC to JPA');
INSERT INTO course_details(id, name) VALUES (10002, 'Spring');
INSERT INTO course_details(id, name) VALUES (10003, 'JPA');
*/
/* STEP 18 - CHAPTER 5
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10001, 'JDBC to JPA', sysdate(), sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10002, 'Spring', sysdate(), sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10003, 'JPA', sysdate(), sysdate());
*/

/* STEP 22 - CHAPTER 6 
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10001, 'JDBC to JPA', sysdate(), sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10002, 'Spring', sysdate(), sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10003, 'JPA', sysdate(), sysdate());


INSERT INTO passport(id, number) VALUES (40001, 'E12345126');
INSERT INTO passport(id, number) VALUES (40002, 'N12345167');
INSERT INTO passport(id, number) VALUES (40003, 'L12345678');

INSERT INTO student(id, name, passport_id) VALUES (20001, 'Ranga', 40001 );
INSERT INTO student(id, name, passport_id) VALUES (20002, 'Adam', 40002);
INSERT INTO student(id, name, passport_id) VALUES (20003, 'Jane', 40003);

INSERT INTO review(id, rating, description) VALUES (50001, '5', 'Great Course');
INSERT INTO review(id, rating, description) VALUES (50002, '4', 'Wonderful Course');
INSERT INTO review(id, rating, description) VALUES (50003, '5', 'Awesome Course');
*/
/* STEP 30 - CHAPTER 8 
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10001, 'JDBC to JPA', sysdate(), sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10002, 'Spring', sysdate(), sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10003, 'JPA', sysdate(), sysdate());


INSERT INTO passport(id, number) VALUES (40001, 'E12345126');
INSERT INTO passport(id, number) VALUES (40002, 'N12345167');
INSERT INTO passport(id, number) VALUES (40003, 'L12345678');

INSERT INTO student(id, name, passport_id) VALUES (20001, 'Ranga', 40001 );
INSERT INTO student(id, name, passport_id) VALUES (20002, 'Adam', 40002);
INSERT INTO student(id, name, passport_id) VALUES (20003, 'Jane', 40003);

INSERT INTO review(id, rating, description, course_id) VALUES (50001, '5', 'Great Course', 10001);
INSERT INTO review(id, rating, description, course_id) VALUES (50002, '4', 'Wonderful Course', 10001);
INSERT INTO review(id, rating, description, course_id) VALUES (50003, '5', 'Awesome Course', 10003);
*/
/* STEP 38 - CHAPTER 8 */
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10001, 'JPA in 50 Steps', sysdate(), sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10002, 'Spring in 50 Steps', sysdate(), sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10003, 'Spring in 100 Steps ', sysdate(), sysdate());


INSERT INTO passport(id, number) VALUES (40001, 'E12345126');
INSERT INTO passport(id, number) VALUES (40002, 'N12345167');
INSERT INTO passport(id, number) VALUES (40003, 'L12345678');

INSERT INTO student(id, name, passport_id) VALUES (20001, 'Ranga', 40001 );
INSERT INTO student(id, name, passport_id) VALUES (20002, 'Adam', 40002);
INSERT INTO student(id, name, passport_id) VALUES (20003, 'Jane', 40003);

INSERT INTO review(id, rating, description, course_id) VALUES (50001, '5', 'Great Course', 10001);
INSERT INTO review(id, rating, description, course_id) VALUES (50002, '4', 'Wonderful Course', 10001);
INSERT INTO review(id, rating, description, course_id) VALUES (50003, '5', 'Awesome Course', 10003);

INSERT INTO student_course(student_id, course_id) VALUES (20001, 10001);
INSERT INTO student_course(student_id, course_id) VALUES (20002, 10001);
INSERT INTO student_course(student_id, course_id) VALUES (20003, 10001);
INSERT INTO student_course(student_id, course_id) VALUES (20001, 10003);

