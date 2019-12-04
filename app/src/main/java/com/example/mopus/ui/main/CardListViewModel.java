package com.example.mopus.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mopus.FFTCGCard;
import com.example.mopus.MopusRepository;

import java.util.List;

public class CardListViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    LiveData<List<FFTCGCard>> cardList;


    public CardListViewModel() {
        MopusRepository repo = new MopusRepository();

        cardList = repo.getCards();
    }

    public LiveData<List<FFTCGCard>> getCards() {
        return cardList;
    }
}
