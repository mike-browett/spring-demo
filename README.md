Created initial project getting feet wet in intellij IDE (should be best for choice for java dev)

All files are created. Here's a summary of the structure:

src/main/java/com/example/usermgmt/
├── UserManagementApplication.java                                                                                                                                                                                               
├── controller/UserController.java                                                                                                                                                                                               
├── service/UserService.java + UserServiceImpl.java                                                                                                                                                                              
├── repository/UserRepository.java                                                                                                                                                                                               
├── entity/UserEntity.java                                                                                                                                                                                                       
├── dto/UserRequestDto.java, UserResponseDto.java, UserFilterDto.java                                                                                                                                                            
├── mapper/UserMapper.java                                                                                                                                                                                                       
├── filter/UserSpecification.java + UserSpecificationBuilder.java                                                                                                                                                                
└── exception/ResourceNotFoundException.java + GlobalExceptionHandler.java

Next steps to get it running:

1. Load Maven — In IntelliJ: right-click pom.xml → Add as Maven Project (this replaces the old .iml setup)
2. Create the Postgres DB: CREATE DATABASE usermgmt;
3. Set env vars (or edit application.yml): DB_USERNAME, DB_PASSWORD
4. Run UserManagementApplication — Hibernate will auto-create the schema (ddl-auto: update)
5. Swagger UI available at http://localhost:8080/swagger-ui.html

To add a new filter condition later — only 3 steps, no existing classes change:
1. Add field to UserFilterDto
2. Add static predicate to UserSpecification
3. Register in UserSpecificationBuilder.build()           


Create a user

curl --location 'http://localhost:8080/api/v1/users' \
--header 'Content-Type: application/json' \
--data '{"id":"michael.browett","firstname":"Michael","lastname":"Browett","active":"YES"}'