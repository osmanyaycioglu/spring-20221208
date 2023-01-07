package com.training.spring.di.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         errorDesc;
    private Integer        errorCode;

    public ErrorObj() {
    }

    public ErrorObj(List<ErrorObj> subErrors,
                    String errorDesc,
                    Integer errorCode) {
        this.subErrors = subErrors;
        this.errorDesc = errorDesc;
        this.errorCode = errorCode;
    }

    public static ErrorObjBuilder builder() {
        return new ErrorObjBuilder();
    }

    public void addSubErrors(ErrorObj errorObjParam){
        if (subErrors == null){
            subErrors = new ArrayList<>();
        }
        subErrors.add(errorObjParam);
    }
    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setSubErrors(List<ErrorObj> subErrors) {
        this.subErrors = subErrors;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String toString() {
        return "ErrorObj(subErrors="
               + this.getSubErrors()
               + ", errorDesc="
               + this.getErrorDesc()
               + ", errorCode="
               + this.getErrorCode()
               + ")";
    }

    public static class ErrorObjBuilder {
        private List<ErrorObj> subErrors;
        private String         errorDesc;
        private Integer        errorCode;

        ErrorObjBuilder() {
        }

        public ErrorObjBuilder withSubError(ErrorObj subError) {
            if (subErrors == null){
                subErrors = new ArrayList<>();
            }
            subErrors.add(subError);
            return this;
        }

        public ErrorObjBuilder withSubErrors(List<ErrorObj> subErrors) {
            this.subErrors = subErrors;
            return this;

        }

        public ErrorObjBuilder withErrorDesc(String errorDesc) {
            this.errorDesc = errorDesc;
            return this;
        }


        public ErrorObjBuilder withErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public ErrorObj build() {
            return new ErrorObj(subErrors,
                                errorDesc,
                                errorCode);
        }

        public String toString() {
            return "ErrorObj.ErrorObjBuilder(subErrors="
                   + this.subErrors
                   + ", errorDesc="
                   + this.errorDesc
                   + ", errorCode="
                   + this.errorCode
                   + ")";
        }
    }
}
