package com.Threaddly.Threaddly.service;

import com.Threaddly.Threaddly.model.request.RegisterRequest;

public interface RegisterService {
    
    public boolean registerUser(RegisterRequest registerRequest);
}
