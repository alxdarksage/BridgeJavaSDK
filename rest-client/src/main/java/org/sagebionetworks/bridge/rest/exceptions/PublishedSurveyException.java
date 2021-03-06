package org.sagebionetworks.bridge.rest.exceptions;

@SuppressWarnings("serial")
public class PublishedSurveyException extends PublishedEntityException {

    public PublishedSurveyException(String message, String url) {
        super(message, url);
    }

    @Override
    public String toString() {
        return "PublishedSurveyException[message=" + getMessage() +
                ", statusCode=" + getStatusCode() +
                ", endpoint=" + getRestEndpoint() + "]";
    }
}
