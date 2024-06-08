package com.mohammad_bakur.Dealer_management_api.requests;

public record DealerRURequest(
        String fullName,
        String email,
        String phoneNumber,
        String password,
        String address
) {}
