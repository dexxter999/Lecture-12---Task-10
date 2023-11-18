package com.example.settingsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.settingsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var adapter: ItemRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUp()

    }



    private fun setUp() {
        adapter = ItemRecyclerViewAdapter()
        binding.recyclerView.adapter = adapter

        adapter.submitList(dataList())
    }


    private fun dataList(): List<Item> {
        return listOf(
            Item(1, R.drawable.ic_profile_logo, "Profile", null, false, R.drawable.ic_arrow_logo),
            Item(2, R.drawable.ic_address_logo, "Address", null, false, R.drawable.ic_arrow_logo),
            Item(3, R.drawable.ic_notification_logo, "Notification", null, false, R.drawable.ic_arrow_logo),
            Item(4, R.drawable.ic_payment_logo, "Payment", null, false, R.drawable.ic_arrow_logo),
            Item(5, R.drawable.ic_security_logo, "Security", null, false, R.drawable.ic_arrow_logo),
            Item(6, R.drawable.ic_language_logo, "Language", "English (US)", false, R.drawable.ic_arrow_logo),
            Item(7, R.drawable.ic_dark_mode_logo, "Dark Mode", null, true, -1),
            Item(8, R.drawable.ic_privacy_policy_logo, "Privacy Policy", null, false, R.drawable.ic_arrow_logo),
            Item(9, R.drawable.ic_help_center_logo, "Help Center", null, false, R.drawable.ic_arrow_logo),
            Item(10, R.drawable.ic_invite_friends_logo, "Invite Friends", null, false, R.drawable.ic_arrow_logo),
            Item(11, R.drawable.ic_log_out_logo, "Logout", null, false, -1, true)
        )
    }
}