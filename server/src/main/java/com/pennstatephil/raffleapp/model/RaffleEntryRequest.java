package com.pennstatephil.raffleapp.model;

import com.pennstatephil.raffleapp.dataaccess.model.DonationEntity;
import com.pennstatephil.raffleapp.dataaccess.model.EntryEntity;
import com.pennstatephil.raffleapp.dataaccess.model.UserEntity;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RaffleEntryRequest {
    @NotNull
    UserEntity user;
    @NotNull
    DonationEntity donation;
    @NotNull
    List<EntryEntity> entries;
}
