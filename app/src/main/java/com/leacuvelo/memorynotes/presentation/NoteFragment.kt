package com.leacuvelo.memorynotes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.leacuvelo.core.data.Note
import com.leacuvelo.memorynotes.R
import com.leacuvelo.memorynotes.framework.NoteViewModel
import kotlinx.android.synthetic.main.fragment_note.*

class NoteFragment : Fragment() {

    private lateinit var viewModel: NoteViewModel
    private var currentNote = Note("","",0L,0L)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)


        checkButton.setOnClickListener {
            if(titleInput.text.toString() != "" || contentInput.text.toString() != ""){
                val time = System.currentTimeMillis()
                currentNote.title = titleInput.text.toString()
                currentNote.content = contentInput.text.toString()
                currentNote.updateTime = time
                if(currentNote.id == 0L){
                    currentNote.creationTime = time
                }
                viewModel.saveNote(currentNote)
            }
            else{
                Navigation.findNavController(it).popBackStack()
            }
        }
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.saved.observe(viewLifecycleOwner, Observer {
            if(it){
                Toast.makeText(context, "Done!", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(titleInput).popBackStack()
            }
            else{
                Toast.makeText(context, "Something went wrong, please try again", Toast.LENGTH_SHORT).show()
            }
        })
    }
}