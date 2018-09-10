package com.zsteven44.android.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;


    public WordViewModel(@NonNull final Application application) {
        super(application);
        this.mRepository = new WordRepository(application);
        this.mAllWords = mRepository.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(@NonNull final Word word) {
        mRepository.insert(word);
    }
}
