package tw.edu.ntub.imd.birc.coursemanagement.exception;

import tw.edu.ntub.birc.common.exception.ProjectException;

public class DuplicateException extends ProjectException {
    public DuplicateException(String message) {
        super(message);
    }

    @Override
    public String getErrorCode(){
        return "Create - Duplicate";
    }
}