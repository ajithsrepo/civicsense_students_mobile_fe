package com.gcc.smartcity.rewards

import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gcc.smartcity.BaseActivity
import com.gcc.smartcity.R

class RewardsActivity : BaseActivity(), RewardsAPIListener {
    private var rewardsListAdapter: RewardsListAdapter? = null
    private var rewardsRecyclerView: RecyclerView? = null
    private var backArrowButton: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewards)
        rewardsRecyclerView = findViewById(R.id.rewardsRecyclerView)
        backArrowButton = findViewById(R.id.backArrowButton)
        backArrowButton?.setOnClickListener {
            goBack()
        }
        setAdapter()
    }

    private fun goBack() {
        this.onBackPressed()
    }

    private fun setAdapter() {
        rewardsListAdapter = RewardsListAdapter()
        rewardsRecyclerView?.layoutManager = LinearLayoutManager(this)
        rewardsRecyclerView?.adapter = rewardsListAdapter
        rewardsListAdapter!!.setData(RewardsController(this, this).getAdapterData())
    }

    override fun onSuccess(rewardsRecyclerViewModel: ArrayList<RewardsRecyclerViewModel>) {
        rewardsListAdapter!!.setData(rewardsRecyclerViewModel)
    }

    override fun onFail(message: String) {
        showErrorDialog(
            getString(R.string.tryAgainLater),
            message,
            getString(R.string.okButtonText)
        )
    }
}
