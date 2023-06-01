package com.khouloudmaamouri.android.features.getBooks.data.local

import com.khouloudmaamouri.android.core.DomainMapper
import com.khouloudmaamouri.android.features.getBooks.data.remote.dto.Book
import javax.inject.Inject

class BookCacheMapper @Inject constructor() : DomainMapper<BookCacheEntity, Book> {

    override fun mapToDomainModel(model: BookCacheEntity): Book {
        return Book(
            image = model.image,
            isbn13 = model.isbn13,
            price = model.price,
            subtitle = model.subtitle,
            title = model.title,
            url = model.url,
        )
    }

    override fun mapFromDomainModel(domainModel: Book): BookCacheEntity {
        return BookCacheEntity(
            image = domainModel.image,
            isbn13 = domainModel.isbn13,
            price = domainModel.price,
            subtitle = domainModel.subtitle,
            title = domainModel.title,
            url = domainModel.url,
        )
    }
}