package com.snjdigitalsolutions.awsec2manager.response;

public class SuccessResponse implements Response{

    protected boolean success = false;

    public SuccessResponse(boolean success)
    {
        this.success = success;
    }

    @Override
    public boolean getSuccess()
    {
        return success;
    }
}
