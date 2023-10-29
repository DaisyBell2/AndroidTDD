package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var liveDataWrapper: LiveDataWrapper
    private var repository: Repository = Repository.Base()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.titleTextView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val button = findViewById<Button>(R.id.actionButton)

        liveDataWrapper = LiveDataWrapper.Base(textView, progressBar, button)
        viewModel = MainViewModel(liveDataWrapper, repository)

        button.setOnClickListener {
            viewModel.load()
        }

    }
}