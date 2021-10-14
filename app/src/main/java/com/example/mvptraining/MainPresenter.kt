package com.example.mvptraining

class MainPresenter(val view: MainView) {
    val model = CountersModel()

    fun counterClick(type: CounterType){
       val dataFromModel = when(type){
            CounterType.FIRST -> model.next(0)
            CounterType.SECOND -> model.next(1)
            CounterType.THIRD -> model.next(2)
        }
        view.setButtonText(type, dataFromModel.toString())
    }
}
