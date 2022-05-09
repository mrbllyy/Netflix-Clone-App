package com.example.netflixclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.netflixclone.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)

        val popularMovies = ArrayList<Movie>()
        popularMovies.add(Movie(1, "The Witcher", "thewitcher", "The witcher Geralt, a mutated monster hunter, struggles to find his place in a world in which people often prove more wicked than beasts."))
        popularMovies.add(Movie(2, "Narcos", "narcos", "Netflix chronicles the rise of the cocaine trade in Colombia and the gripping real-life stories of drug kingpins of the late '80s in this raw, gritty original series. Also detailed are the actions taken by law enforcement as they battle in the war on drugs, targeting notorious and powerful figures that include drug lord Pablo Escobar. As efforts are made to control cocaine, one of the world's most valuable commodities, the many entities involved -- legal, political, police, military and civilian -- find themselves in conflict."))
        popularMovies.add(Movie(3, "#blackAF", "blackaf", "A man takes an irreverent and honest approach to parenting and relationships."))

        val trendingMovies = ArrayList<Movie>()
        trendingMovies.add(Movie(4, "Tiger King", "tigerking", "An exploration of big cat breeding and its bizarre underworld, populated by eccentric characters, namely zoo operator Joseph Maldonado-Passage."))
        trendingMovies.add(Movie(5, "Sex Education", "sexeducation", "Socially awkward high school student Otis may not have much experience in the lovemaking department, but he gets good guidance on the topic in his personal sex ed course -- living with mom Jean, who is a sex therapist. Being surrounded by manuals, videos and tediously open conversations about sex, Otis has become a reluctant expert on the subject. When his classmates learn about his home life, Otis decides to use his insider knowledge to improve his status at school, so he teams with whip-smart bad girl Maeve to set up an underground sex therapy clinic to deal with their classmates' problems. But through his analysis of teenage sexuality, Otis realizes that he may need some therapy of his own."))
        trendingMovies.add(Movie(6, "6 Underground", "sixunderground", "Six individuals from all around the globe, each the very best at what they do, have been chosen not only for their skill, but for a unique desire to delete their pasts to change the future."))

        val watchAgainMovies = ArrayList<Movie>()
        watchAgainMovies.add(Movie(7, "Ozark", "ozark", "Created by Bill Dubuque (\"The Accountant,\" \"The Judge\"), this drama series stars Jason Bateman as Marty Byrde, a financial planner who relocates his family from Chicago to a summer resort community in the Ozarks. With wife Wendy and their two kids in tow, Marty is on the move after a money-laundering scheme goes wrong, forcing him to pay off a substantial debt to a Mexican drug lord in order to keep his family safe. While the Byrdes' fate hangs in the balance, the dire circumstances force the fractured family to reconnect."))
        watchAgainMovies.add(Movie(8, "Coffee Kareem", "coffeekareem", "A 12-year-old's scheme to frighten off his mum's new boyfriend, police officer James Coffee, backfires and exposes his family to a secret network of criminal activity."))
        watchAgainMovies.add(Movie(9, "To All Boys I've Loved Before", "toalltheboysivelovedbefore", "Lara Jean writes secret, soul-baring letters to her five crushes, but never meant to send them. Now they are out and wreaking havoc on her life."))




        binding.rvPopular.adapter = MovieAdapter(requireContext(), popularMovies)
        binding.rvPopular.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        binding.rvTrending.adapter = MovieAdapter(requireContext(), trendingMovies)
        binding.rvTrending.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        binding.rvWatchAgain.adapter = MovieAdapter(requireContext(), watchAgainMovies)
        binding.rvWatchAgain.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        binding.buttonTVShows.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homePageFragment_to_tvShowsFragment)
        }

        binding.buttonMovies.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homePageFragment_to_moviesFragment)
        }

        binding.buttonMyList.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homePageFragment_to_listFragment)
        }

        return binding.root
    }

}