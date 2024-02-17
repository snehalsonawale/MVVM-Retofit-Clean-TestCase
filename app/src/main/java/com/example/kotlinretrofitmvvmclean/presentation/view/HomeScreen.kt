package com.example.kotlinretrofitmvvmclean.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinretrofitmvvmclean.domain.model.QuoteList
import com.example.kotlinretrofitmvvmclean.domain.model.Result
import com.example.kotlinretrofitmvvmclean.presentation.view.ui.theme.KotlinRetrofitMVVMCleanTheme
import com.example.kotlinretrofitmvvmclean.presentation.view.viewModel.MainViewModel

class HomeScreen : ComponentActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.getApiData()

        setContent {
            KotlinRetrofitMVVMCleanTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    viewModel.observeMovieLiveData().observe(this, Observer {

                        Log.d("##ORBRV",it.toString())


                        setContent {
                            KotlinRetrofitMVVMCleanTheme {
                                // A surface container using the 'background' color from the theme
                                Surface(
                                    modifier = Modifier.fillMaxSize(),
                                    color = MaterialTheme.colorScheme.background
                                ) {

                                    Greeting(it)
                                }
                            }
                        }



                    })

                }
            }
        }
    }
}

@Composable
fun Greeting(item:List<QuoteList>) {
    Log.d("##itemlist1",item.toString())
    var lit : List<Result> = item.get(0).results
    var lit2 : List<Result> = item[0].results

   // StudentRow(item.get(0).results)
   // StudentRow(lit)
    LazyColumn{
        items(lit2){
            StudentRow3(it)
        }
    }
}


@Composable
fun StudentRow(itemlist: List<Result>) {
    LazyColumn{
        items(itemlist){
            StudentRow3(it)
        }
    }


}
@Composable
fun StudentRow3(result1:Result)
{
    Log.d("##result1",result1.toString())
    Card(modifier = Modifier
        .padding(all = 10.dp)
        .fillMaxWidth()) {
       Column(modifier = Modifier.padding(all = 10.dp)) {
           Text(text = result1.author)
           Text(text = result1._id)
           Text(text = result1.dateAdded)
           Text(text = result1.authorSlug)
           Text(text = result1.dateModified)
           Text(text = result1.tags.joinToString(" "))
           Text(text = result1.content)

       }
   }

}