module dev.medzik.common {
    requires transitive kotlin.stdlib;
    requires kotlinx.coroutines.core;

    exports dev.medzik.common.extensions;
    exports dev.medzik.common.io;
}
