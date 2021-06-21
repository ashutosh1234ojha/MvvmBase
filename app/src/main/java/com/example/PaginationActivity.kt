package com.example

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmbase.R
import kotlinx.android.synthetic.main.activity_pagination.*


class PaginationActivity : AppCompatActivity() {

    val limit = 10
    var skip = 0
    var list: MutableList<String> = mutableListOf()
    var temp: MutableList<String> = mutableListOf()
    lateinit var rvAdapter: PaginationAdapter
    lateinit var linear: LinearLayoutManager
    var isLastPage = false
    var isLoading = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagination)


        btn.setOnClickListener {
            this@PaginationActivity.isLoading = true

            pb.visibility = View.VISIBLE

            temp.add("P");
            rvAdapter.notifyItemInserted(temp.size - 1);

            load()
            //            }
        }
        for (i in 1..50) {
            list.add("$i")
        }

        linear = LinearLayoutManager(applicationContext)

        rvAdapter = PaginationAdapter()

        rv.apply {
            layoutManager = linear
            adapter = rvAdapter
        }

        //  rvAdapter.setValue(temp)

        val handler = object : PaginationListener(linear) {
            override fun isLastPage(): Boolean {

                return this@PaginationActivity.isLastPage
            }

            override fun loadMoreItems() {
                temp.add("P");
                rvAdapter.notifyItemInserted(temp.size - 1);

                load()
            }

            override fun isLoading(): Boolean {
                return this@PaginationActivity.isLoading
            }
            //   override fun call(context: String?) { println("Call: $context") }
            //   override fun run(context: String?) { println("Run: $context")  }
        }


        rv.addOnScrollListener(handler)


    }

    fun load() {
        Handler().postDelayed({

            temp.removeAt(temp.size - 1);
            //  temp.no(studentList.size());

            rvAdapter.notifyItemRemoved(temp.size)

            if (skip < list.size) {
                for (i in skip until skip + limit) {
                    temp.add(list[i])
                }
                skip = temp.size;
                rvAdapter.setValue(temp)

                isLastPage = false;

                this@PaginationActivity.isLoading = true
                pb.visibility = View.VISIBLE

            } else {
                Toast.makeText(this@PaginationActivity, "All added", Toast.LENGTH_SHORT).show()
                isLastPage = true;

            }
            pb.visibility = View.GONE

            isLoading = false
        }, 3000)
    }
}