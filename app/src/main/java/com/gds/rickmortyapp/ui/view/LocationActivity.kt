package com.gds.rickmortyapp.ui.view

import androidx.recyclerview.widget.RecyclerView
import com.gds.rickmortyapp.data.database.RickMortyDatabase
import com.gds.rickmortyapp.data.datasource.ApiDataSource
import com.gds.rickmortyapp.data.model.localizacao.LocationResult
import com.gds.rickmortyapp.data.repository.LocationRepository
import com.gds.rickmortyapp.databinding.ActivityLocationBinding
import com.gds.rickmortyapp.di.Injection
import com.gds.rickmortyapp.ui.adapter.CharacterAdapter
import com.gds.rickmortyapp.ui.adapter.LocationAdapter
import com.gds.rickmortyapp.ui.view.base.BaseWithViewModelActivity
import com.gds.rickmortyapp.ui.viewmodel.LocationViewModel
import com.gds.rickmortyapp.util.extension.dialog
import com.gds.rickmortyapp.util.result.ResultUtil

class LocationActivity : BaseWithViewModelActivity<ActivityLocationBinding, LocationViewModel>() {
    private lateinit var locationList: List<LocationResult>
    override val viewModel: LocationViewModel = getMyViewModels()

    private fun getMyViewModels(): LocationViewModel {
        return LocationViewModel(
            LocationRepository(
                RickMortyDatabase.invoke(this),
                ApiDataSource(Injection.api)
            )
        )
    }

    override fun getLayoutBinding() = ActivityLocationBinding.inflate(layoutInflater)

    override fun getViewRoot() = binding.root

    override fun codeInject() {
        observers()
    }

    private fun observers() {

        viewModel.locationList.observe(this) { result ->
            when (result) {
                is ResultUtil.Success -> {
//                    binding.pbMain.hide()
                    locationList = result.data.results
                    initRecycler(locationList)
                }
                is ResultUtil.Error -> {
                    errorResult(result)
                }
                is ResultUtil.Loading -> {
                    showLoading()
                }
            }
        }

    }

    private fun initRecycler(list: List<LocationResult>,) {

    }

    private fun showLoading() {
//        binding.pbMain.show()
    }

    private fun errorResult(result: ResultUtil.Error) {
//        binding.pbMain.hide()
        dialog("Falha", result.msg)
    }

}