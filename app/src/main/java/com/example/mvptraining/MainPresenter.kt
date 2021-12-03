package com.example.mvptraining

import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screen: IScreens) : MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screen.users())
    }
    fun backClicked(){
        router.exit()
    }
}