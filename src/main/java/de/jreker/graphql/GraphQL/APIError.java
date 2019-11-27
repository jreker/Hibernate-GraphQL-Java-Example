package de.jreker.graphql.GraphQL;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ErrorType;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.execution.ExecutionPath;
import graphql.language.SourceLocation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class APIError extends RuntimeException implements GraphQLError {
    private int errorCode;

    public APIError(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        Map<String,Object> customErrorAttribute = new LinkedHashMap<>();
        customErrorAttribute.put("errorCode",errorCode);
        customErrorAttribute.put("errorMessage", getMessage());
        return customErrorAttribute;
    }
}
