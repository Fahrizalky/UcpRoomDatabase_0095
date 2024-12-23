package com.example.ucp2pam.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ucp2pam.ui.view.HomeView
import com.example.ucp2pam.ui.view.barang.DetailBarView
import com.example.ucp2pam.ui.view.barang.HomeBarView
import com.example.ucp2pam.ui.view.barang.InsertBarView
import com.example.ucp2pam.ui.view.barang.UpdateBarView
import com.example.ucp2pam.ui.view.suplier.HomeSupView
import com.example.ucp2pam.ui.view.suplier.InsertSupView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route
    ){
        composable(
            route = DestinasiHome.route
        ) {
            HomeView(
                onNavigateAddBrg = {
                    navController.navigate(DestinasiInsertBrg.route)
                },
                onNavigateAddSup = {
                    navController.navigate(DestinasiInsertSpl.route)
                },
                onNavigateListBrg = {
                    navController.navigate(DestinasiHomeBrg.route)
                },
                onNavigateListSup = {
                    navController.navigate(DestinasiHomeSpl.route)
                },
                modifier = modifier
            )
        }
        composable(
            route = DestinasiHomeSpl.route
        ){
            HomeSupView(
                onBack = {navController.popBackStack()},
                modifier = modifier
            )
        }
        composable(
            route = DestinasiHomeBrg.route
        ){
            HomeBarView(
                onDetailClick = {nama ->
                    navController.navigate("${DestinasiDetail.route}/$nama")
                    println(
                        "PengelolaHalaman: nama = $nama"
                    )
                },
                onBack = {navController.popBackStack()},
                modifier = modifier
            )
        }
        composable(
            route = DestinasiInsertSpl.route
        ){
            InsertSupView(
                onBack = {navController.popBackStack()},
                onNavigate = { navController. popBackStack()},
                modifier = modifier
            )
        }
        composable(
            route = DestinasiInsertBrg.route
        ){
            InsertBarView(
                onBack = {navController.popBackStack()},
                onNavigate = { navController.popBackStack()},
                modifier = modifier
            )
        }
        composable(
            DestinasiDetail.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiDetail.NAMA){
                    type = NavType.StringType
                }
            )
        ){
            val nim = it.arguments?.getString(DestinasiDetail.NAMA)
            nim?.let { nama ->
                DetailBarView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiUpdate.route}/$it")
                    },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(
            DestinasiUpdate.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiUpdate.NAMA){
                    type = NavType.StringType
                }
            )
        ){
            UpdateBarView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }


    }
}

