package com.summerbreeze11.notionboard.dialoghelper

import android.app.AlertDialog
import com.summerbreeze11.notionboard.MainActivity
import com.summerbreeze11.notionboard.R
import com.summerbreeze11.notionboard.accounthelper.AccountHelper
import com.summerbreeze11.notionboard.databinding.SignDialogBinding

class DialogHelper(act: MainActivity) {
    private val act = act
    private val accHelper = AccountHelper(act)

    fun createSignDialog(index: Int) {
        val builder = AlertDialog.Builder(act)
        val rootDialogElement = SignDialogBinding.inflate(act.layoutInflater)

        if (index == DialogConst.SIGN_UP_STATE) {
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.ac_sign_up)
            rootDialogElement.btSignUpIn.text = act.resources.getString(R.string.sign_up_action)
        } else {
            rootDialogElement.tvSignTitle.text = act.resources.getString(R.string.ac_sign_in)
            rootDialogElement.btSignUpIn.text = act.resources.getString(R.string.sign_in_action)
        }
        rootDialogElement.btSignUpIn.setOnClickListener {
            if (index == DialogConst.SIGN_UP_STATE) {
                accHelper.signUpWithEmail(
                    rootDialogElement.edSignEmail.text.toString(),
                    rootDialogElement.edSignPassrowd.text.toString()
                )
            } else {

            }
        }
        builder.setView(rootDialogElement.root)
        builder.show()
    }
}