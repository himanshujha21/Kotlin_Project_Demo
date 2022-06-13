package com.example.dynamicappexample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    var gitHubDataList = MutableLiveData<List<GitHubData>>()












}

