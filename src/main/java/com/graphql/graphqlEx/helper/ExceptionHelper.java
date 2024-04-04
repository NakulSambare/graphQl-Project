package com.graphql.graphqlEx.helper;

public class ExceptionHelper {


    public static RuntimeException throwResourceNotFoundException(){
        return new RuntimeException("Resource not found");
    }
}
