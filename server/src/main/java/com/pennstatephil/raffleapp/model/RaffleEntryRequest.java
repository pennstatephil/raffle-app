package com.pennstatephil.raffleapp.model;

import com.pennstatephil.raffleapp.dataaccess.model.DonationEntity;
import com.pennstatephil.raffleapp.dataaccess.model.EntryEntity;
import com.pennstatephil.raffleapp.dataaccess.model.UserEntity;
import lombok.Data;

import java.util.List;

@Data
public class RaffleEntryRequest {
    UserEntity user;
    DonationEntity donation;
    List<EntryEntity> entries;
}
