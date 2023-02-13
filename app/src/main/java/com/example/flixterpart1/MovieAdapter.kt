package com.example.flixterpart1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter (
    private val Movies: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?
)
    : RecyclerView.Adapter<MovieAdapter.CurrentMovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentMovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie, parent, false)
        return CurrentMovieViewHolder(view)
    }



    inner class CurrentMovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: Movie? = null
        val mName: TextView = mView.findViewById<View>(R.id.mName) as TextView
        val mDescription: TextView = mView.findViewById<View>(R.id.mDescription) as TextView
        // val mRanking: TextView = mView.findViewById<View>(id.ranking) as TextView
        val mPoster: ImageView = mView.findViewById<View>(R.id.mPoster) as ImageView
        //   val mBookDescription: TextView = mView.findViewById<View>(id.book_description) as TextView
        //  val mBuyButton: Button = mView.findViewById<Button>(id.buy_button) as Button



        //  override fun toString(): String {
        //       return mBookTitle.toString() + " '" + mBookAuthor.text + "'"
        //   }
    }


    override fun onBindViewHolder(holder: CurrentMovieViewHolder, position: Int) {
        val currentMovie = Movies[position]

        holder.mItem = currentMovie
        holder.mName.text = currentMovie.title
        // holder.mBookAuthor.text = book.author
        // holder.mRanking.text=book.rank.toString()
        //holder.mBookImage
        holder.mDescription.text= currentMovie.overview
        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500"+currentMovie.posterPath)
            .placeholder(R.drawable.loading)
            .error(R.drawable.imagenotfound)
            .centerInside()
            .into(holder.mPoster)

    }
    override fun getItemCount(): Int {
        // TODO("Not yet implemented")
        return Movies.size
    }

    }