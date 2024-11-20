package com.maninmiddle.feature_search.presentation.vacancies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maninmiddle.feature_search.R
import com.maninmiddle.feature_search.databinding.FragmentVacanciesBinding

class VacanciesFragment : Fragment() {
    private var _viewBinding: FragmentVacanciesBinding? = null
    private val viewBinding:  FragmentVacanciesBinding
        get() = _viewBinding ?: throw RuntimeException("FragmentVacanciesBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentVacanciesBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}