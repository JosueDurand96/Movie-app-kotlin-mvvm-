package com.example.movieappmvvmjd.ui.popular_movie

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieappmvvmjd.data.api.POSTER_BASE_URL
import com.example.movieappmvvmjd.data.repository.NetworkState
import com.example.movieappmvvmjd.data.vo.Movie
import com.example.movieappmvvmjd.data.vo.MovieDetails
import com.example.movieappmvvmjd.ui.single_movie_details.SingleMovie
import kotlinx.android.synthetic.main.activity_single_movie.view.*
import kotlinx.android.synthetic.main.movie_list_item.view.*
import kotlinx.android.synthetic.main.network_state_item.view.*

class PopularMoviePageListAdapter :PagedListAdapter<Movie,RecyclerView.ViewHolder>(MovieDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class MovieDiffCallback:DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem==oldItem
        }
    }


    class MovieItemViewHolder(view:View):RecyclerView.ViewHolder(view){
        fun bind(movie: Movie?,context: Context){
            itemView.cv_movie_title.text= movie?.title
            itemView.cv_movie_release_date.text = movie?.releaseDate
            val moviePosterURL:String= POSTER_BASE_URL+movie?.poster_path
            Glide.with(itemView.context)
                .load(moviePosterURL)
                .into(itemView.cv_iv_movie_poster)
            itemView.setOnClickListener {
                val intent= Intent(context, SingleMovie::class.java)
                intent.putExtra("id",movie?.id)
                context.startActivity(intent)
            }
        }
    }

    class NetworkStateItemViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bind(networkState: NetworkState?){
            if (networkState != null && networkState== NetworkState.LOADING){
                itemView.progress_bar_item.visibility=View.VISIBLE
            }else{
                itemView.progress_bar_item.visibility=View.GONE
            }
        }
    }

}