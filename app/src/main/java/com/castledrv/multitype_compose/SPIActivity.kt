package com.castledrv.multitype_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.castledrv.core.ComposableItem
import com.castledrv.core.ComposableServiceManager


class SPIActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //SPI
        ComposableServiceManager.collectServices()

        setContent {
            val viewModel: ManageShowcaseViewModel = viewModel()
            LazyColumn(
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 10.dp,
                    top = 10.dp
                )
            ) {
                items(viewModel.produceItems()) {
                    ComposableItem(item = it)
                }
            }
        }
    }

}
