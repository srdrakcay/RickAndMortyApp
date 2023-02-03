package com.serdar.rickandmorty.ui.home

import com.google.common.truth.Truth.assertThat
import com.serdar.rickandmorty.domain.constant.rickAndMortyEntityList
import org.junit.Before
import org.junit.Test

internal class RickAndMortyUiMapperImplTest {

    private val rickAndMortyUiMapperImpl = RickAndMortyUiMapperImpl()

    private lateinit var uiElements: List<HomeUiData>


    @Before
    fun setup() {
        uiElements = rickAndMortyUiMapperImpl.map(rickAndMortyEntityList)
    }

    @Test
    fun when_entity_mapped_is_name_correct() {
        assertThat(uiElements[0].name).isEqualTo(rickAndMortyEntityList[0].name)
    }

    @Test
    fun when_entity_mapped_is_image_url_correct() {
        assertThat(uiElements[0].image).isEqualTo(rickAndMortyEntityList[0].type)
    }

    @Test
    fun when_entity_mapped_is_size_of_lists_same() {
        assertThat(uiElements.size).isEqualTo(rickAndMortyEntityList.size)
    }

    @Test
    fun when_input_entity_is_null_is_result_empty() {
        val newUiElements = rickAndMortyUiMapperImpl.map(null)
        assert(newUiElements.isEmpty())
    }
}