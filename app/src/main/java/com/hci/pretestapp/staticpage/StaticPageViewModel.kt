package asia.digiasia.kaspro.staticpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hci.pretestapp.common.base.ViewModelType
import javax.inject.Inject


interface StaticPageViewModelType : ViewModelType

class StaticPageViewModel : ViewModel(),
        StaticPageViewModelType {

    @Suppress("UNCHECKED_CAST")
    class Factory
    @Inject constructor() :
            ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(StaticPageViewModel::class.java)) {
                return StaticPageViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
