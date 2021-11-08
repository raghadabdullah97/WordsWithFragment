    package com.example.wordsapp
    import android.os.Bundle
    import android.view.*
    import androidx.core.content.ContextCompat
    import androidx.fragment.app.Fragment
    import androidx.recyclerview.widget.GridLayoutManager
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.example.wordsapp.WordListFragment.Companion.LETTER

    import com.example.wordsapp.databinding.FragmentLetterListBinding


    class LetterListFragment : Fragment() {
        private var _binding: FragmentLetterListBinding? = null
        private val binding get() = _binding!!
        private var isLinearLayoutManager = true


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            arguments?.let {
                letterId = it.getString(LETTER).toString()
            }
        }
        private lateinit var letterId: String
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            _binding = FragmentLetterListBinding.inflate(inflater, container, false)
            val view = binding.root
            return view

        }

        private lateinit var recyclerView: RecyclerView


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            recyclerView.adapter = WordAdapter(letterId, requireContext())
            recyclerView = binding.recyclerView
            chooseLayout()


        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

        override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
            inflater.inflate(R.menu.layout_menu, menu)

            val layoutButton = menu.findItem(R.id.action_switch_layout)
            setIcon(layoutButton)

        }





        private fun chooseLayout() {
            when (isLinearLayoutManager) {
                true -> {
                    recyclerView.layoutManager = LinearLayoutManager(context)
                    recyclerView.adapter = LetterAdapter()
                }
                false -> {
                    recyclerView.layoutManager = GridLayoutManager(context, 4)
                    recyclerView.adapter = LetterAdapter()
                }
            }
        }




            private fun setIcon(menuItem: MenuItem?) {
                if (menuItem == null)
                    return
                menuItem.icon =
                    if (isLinearLayoutManager)
                        ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
                    else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
            }



                // Set the drawable for the menu icon based on which LayoutManager is currently in use

            // An if-clause can be used on the right side of an assignment if all paths return a value.
            // The following code is equivalent to
            // if (isLinearLayoutManager)
            //     menu.icon = ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            // else menu.icon = ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)





        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.action_switch_layout -> {
                    // Sets isLinearLayoutManager (a Boolean) to the opposite value
                    isLinearLayoutManager = !isLinearLayoutManager
                    // Sets layout and icon
                    chooseLayout()
                    setIcon(item)

                    return true
                }

                else -> super.onOptionsItemSelected(item)
            }
        }










    }

        /**
         * Initializes the [Menu] to be used with the current [Activity]
         */


        /**
         * Determines how to handle interactions with the selected [MenuItem]
         */




  //  Otherwise, do nothing and use the core event handling

                // when clauses require that all possible paths be accounted for explicitly,
                //  for instance both the true and false cases if the value is a Boolean,
                //  or an else to catch all unhandled cases.



