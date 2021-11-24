package com.bee.fresh.presentation.base

import moxy.MvpPresenter

abstract class BasePresenter<V : BaseView> : MvpPresenter<V>() {
}