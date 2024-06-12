package com.example.appmusickotlin.ui.home.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appmusickotlin.adapter.AlbumAdapter
import com.example.appmusickotlin.adapter.MusicAdapter

import com.example.appmusickotlin.databinding.FragmentPlaylistsfragmentBinding
import com.example.appmusickotlin.model.DataListPlayList
import com.example.appmusickotlin.model.ListAlbums
import com.example.appmusickotlin.ui.dialogs.DialogAddPlaylistFragment


interface PlaylistAddedListener {
    fun onPlaylistAdded(album: DataListPlayList)
}

class PlayListsFragment : Fragment(), PlaylistAddedListener {
    private lateinit var binding: FragmentPlaylistsfragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlaylistsfragmentBinding.inflate(inflater, container, false)


        val album = ListAlbums.albumList
        if(album.isNullOrEmpty()){
            binding.group.visibility = View.VISIBLE
            binding.rccAlbum.visibility = View.GONE
        } else {
            val adapter = AlbumAdapter(ListAlbums.albumList!!)
            binding.rccAlbum.layoutManager = LinearLayoutManager(this.context)
            binding.rccAlbum.adapter = adapter
            binding.group.visibility = View.GONE
            binding.rccAlbum.visibility = View.VISIBLE

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddPlaylist.setOnClickListener {
            val dialogAddPlaylist = DialogAddPlaylistFragment()
            dialogAddPlaylist.setPlaylistAddedListener(this) // phải thêm hàm này vào
            dialogAddPlaylist.show(childFragmentManager, "Add Playlist")
        }



    }

    override fun onPlaylistAdded(album: DataListPlayList) {

        if (ListAlbums.albumList == null) {
            ListAlbums.albumList = mutableListOf()
        }
        ListAlbums.albumList?.add(album)

        val adapter = AlbumAdapter(ListAlbums.albumList!!)
        binding.rccAlbum.layoutManager = LinearLayoutManager(this.context)
        binding.rccAlbum.adapter = adapter
        binding.group.visibility = View.GONE
        binding.rccAlbum.visibility = View.VISIBLE

    }

}
