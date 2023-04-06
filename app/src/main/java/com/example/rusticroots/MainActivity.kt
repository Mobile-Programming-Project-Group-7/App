package com.example.rusticroots

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import com.example.rusticroots.model.data.MenuItem
import com.example.rusticroots.ui.modules.GooglePayButton
import com.example.rusticroots.ui.theme.RusticRootsTheme
import com.example.rusticroots.viewmodel.PaymentGViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
       /* val paymentGVM: PaymentGViewModel by viewModels()*/

        setContent {
            RusticRootsTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState= scaffoldState,
                    topBar = {
                             AppBar(
                                 onNavigationIconClick = {
                                     scope.launch {
                                         scaffoldState.drawerState.open()
                                     }

                                 }
                             )
                    },
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items=listOf(
                                MenuItem("profile",
                                    title = "Profile",
                                    contentDescription = "Go to your profile page",
                                    icon = Icons.Default.Person
                                ),
                            MenuItem("Home",
                                title = "Home",
                                contentDescription = "Go to homescreen",
                                icon = Icons.Default.Home
                                ),
                                MenuItem("favourite",
                                    title = "Orders",
                                    contentDescription = "Your favourite orders",
                                    icon = Icons.Default.Favorite
                                ),
                                MenuItem("settings",
                                    title = "Settings",
                                    contentDescription = "Go to settings screen",
                                    icon = Icons.Default.Settings
                                ),
                                MenuItem("feedback",
                                    title = "Feedback",
                                    contentDescription = "Go to feedback screen",
                                    icon = Icons.Default.Notifications
                                ),
                                MenuItem("help",
                                    title = "Help",
                                    contentDescription = "Get help",
                                    icon = Icons.Default.Info
                                ),
                        ),
                            onItemClick= {
                                println("Clicked on ${it.title}")
                            }
                        )
                    }
                ) {


                }}}}}
                // A surface container using the 'background' color from the theme
               /* Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp(paymentGVM = paymentGVM)
                }
            }
        }
        // Check Google Pay availability
        paymentGVM.canUseGooglePay.observe(this, Observer(::setGooglePayAvailable) )
    }
    /**
     * If Google pay is not available, user gets notified
     */
    private fun setGooglePayAvailable(available: Boolean) {
        if (available) {
            Log.d("**********************","AVAILABLE")
        } else {
            Toast.makeText(
                this,
                getString(R.string.google_pay_NA),
                Toast.LENGTH_LONG
            ).show()
            Log.e("**********************","NOT AVAILABLE")
        }
    }
}

@Composable
fun MyApp(paymentGVM: PaymentGViewModel) {
    Column() {
        GooglePayButton(paymentGVM = paymentGVM)
    }
}*/