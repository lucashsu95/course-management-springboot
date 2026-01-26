package tw.edu.ntub.imd.birc.coursemanagement.service.transformer;

import javax.annotation.Nonnull;

public interface BeanEntityTransformer<B, E> {
    @Nonnull
    E transferToEntity(@Nonnull B b);

    @Nonnull
    B transferToBean(@Nonnull E e);
}
