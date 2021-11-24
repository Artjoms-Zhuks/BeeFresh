package com.bee.fresh.presentation.base

import androidx.annotation.LayoutRes
import moxy.MvpAppCompatFragment

abstract class BaseFragment(@LayoutRes val layout: Int) : MvpAppCompatFragment(layout), BaseView {
}