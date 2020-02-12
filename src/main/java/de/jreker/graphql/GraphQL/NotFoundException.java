package de.jreker.graphql.graphQL;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.language.SourceLocation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotFoundException extends GraphQLException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public NotFoundException(String message, int objectId) {
        super(message);
        extensions.put("Id of not found object", objectId);
    }
    //i dont want to have the stack trace in the graphql error message
    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }
    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }
}