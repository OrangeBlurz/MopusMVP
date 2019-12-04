package com.example.mopus.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mopus.CardListAdapter;
import com.example.mopus.FFTCGCard;
import com.example.mopus.R;

import java.util.List;

public class CardListFragment extends Fragment {
    private static final String TAG = "CardListFragment";

    private CardListViewModel viewModel;
    private RecyclerView recyclerView;

    public static CardListFragment newInstance() {
        return new CardListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_list_fragment, container, false);
        recyclerView = view.findViewById(R.id.card_list_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(CardListViewModel.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));

        final CardListAdapter adapter = new CardListAdapter();
        adapter.setListener(new CardListAdapter.OnItemClickListener() {
            @Override
            public void onClick(FFTCGCard card) {
                Log.d(TAG, "onClick: " + card.getName());
                CardListFragmentDirections.ActionCardClicked action =
                        CardListFragmentDirections.actionCardClicked(card.getCode());
                //NavHostFragment.findNavController(CardListFragment.this).navigate(R.id.action_cardClicked);
                NavHostFragment.findNavController(CardListFragment.this).navigate(action);

            }
        });
        recyclerView.setAdapter(adapter);

        viewModel.getCards().observe(this, new Observer<List<FFTCGCard>>() {
            @Override
            public void onChanged(List<FFTCGCard> fftcgCards) {
                Log.d(TAG, "onChanged: list changed:" + fftcgCards.size());
                adapter.setCardList(fftcgCards);
            }
        });
    }



}
