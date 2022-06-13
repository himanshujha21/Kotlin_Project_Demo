package com.example.recyclerviewdemo

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.databinding.ContactRowBinding
import com.example.recyclerviewdemo.databinding.DialogAddUpdateBinding
import java.util.ArrayList

//extend RecyclerView
class RecyclerContactAdapter(val context: Context, var arrData: ArrayList<ContactModel>) :
   //View Holder Class inside the RecyclerContactAdapter Class that why we write <RecyclerContactAdapter.ViewHolder>
    RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>() {


    //Also, make sure you pass the root view to the parent(super) class of Viewholder like this RecyclerView.ViewHolder(itemBinding.root)
    // by accessing the passed binding class object.

    //anything hold the view known as view holder
    //new Class of ViewHolder
    //extend RecyclerView.ViewHolder(parent class)
    //View Holder Class hold the view referance


    class ViewHolder(binding: ContactRowBinding) : RecyclerView.ViewHolder(binding.root) {
        val ivContact = binding.ivContact
        val tvName = binding.tvName
        val tvContact = binding.tvContact
        val cardView = binding.cardView

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ContactRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        //val view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false)
        return ViewHolder(binding)
    }
// Bind means, data setup in this method
//holder is the variable which hold the ViewHolder Class Object
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = arrData[position]
        holder.ivContact.setImageResource(model.img)
        holder.tvName.text = model.name
        holder.tvContact.text = model.number




        holder.cardView.setOnClickListener {
            Dialog(context).apply {
                val dialogBinding = DialogAddUpdateBinding.inflate(layoutInflater)
                setContentView(dialogBinding.root)
                dialogBinding.tvHeader.text = "Update Contact"
                dialogBinding.editName.setText(arrData[position].name)
                dialogBinding.editPhone.setText(arrData[position].number)
                dialogBinding.btnAdd.text = "Save"

                dialogBinding.btnAdd.setOnClickListener {
                    arrData[position] = ContactModel(
                        arrData[position].img,
                        dialogBinding.editName.text.toString(),
                        dialogBinding.editPhone.text.toString()

                    )
                    notifyItemChanged(position)
                    dismiss()


                }

                dialogBinding.btnCancel.setOnClickListener {
                    dismiss()
                }
                show()


            }

        }
        holder.cardView.setOnLongClickListener {
            AlertDialog.Builder(context).apply {
                setMessage("Are you sure want to delete this contact?")
                setPositiveButton("Yes") { p0, p1 ->
                    arrData.removeAt(position)
                    notifyItemRemoved(position)
                }

                setNegativeButton("No") { dialog, which ->

                }

                show()
            }



            true

        }

        //animation on the view
        AnimatorSet().apply {
            playTogether(
                ObjectAnimator.ofFloat(holder.cardView, View.ALPHA, 0f, 1f).apply {
                    duration = 400

                },

                ObjectAnimator.ofFloat(holder.cardView, View.TRANSLATION_X, 500f, 0f).apply {
                    duration = 400

                }

            )


            start()
        }


    }


    override fun getItemCount(): Int {
        return arrData.size
    }


}

