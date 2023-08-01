package com.example.gofilter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

//ViewModel for Search tab
class MainViewModel: ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _profiles = MutableStateFlow(allProfiles)
    val profiles = searchText
        .debounce(1000L)
        .onEach { _isSearching.update { true } }
        .combine(_profiles) { text, profiles ->
            if(text.isBlank()) {
                profiles
            } else {
                profiles.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _profiles.value
        )

    fun onSearchChange(text: String) {
        _searchText.value = text
    }
}

//Data class for searching "profiles"
data class Profile(
    val firstName: String,
    val lastName: String
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(
            "$firstName$lastName",
            "$firstName $lastName",
            "${firstName.first()} ${lastName.first()}",
        )

        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

//Hard coded search list
private val allProfiles = listOf(
    Profile(
        firstName = "John",
        lastName = "Sarmiento"
    ),
    Profile(
        firstName = "Marius",
        lastName = "Laggui"
    ),
    Profile(
        firstName = "Gwyneth",
        lastName = "Silverio"
    ),
    Profile(
        firstName = "Mika",
        lastName = "Reyes"
    ),
)