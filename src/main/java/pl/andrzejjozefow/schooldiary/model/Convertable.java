package pl.andrzejjozefow.schooldiary.model;

import java.util.Collection;
import java.util.stream.Collectors;

public interface Convertable<F, T> {

    //podmienić metody konwertujące w DTO
    public T convert(F from);

    default public Collection<T> from(Collection<F> fElements) {
        Collection<T> convertedElement =
            fElements.stream()
                .map(element -> convert(element))
                .collect(Collectors.toList());

        return convertedElement;
    }
}
