package org.will.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 通过扩展JpaRepository， ReadingListRepository直接继承了18个执行常用持久化操作
 * 的方法。 JpaRepository是个泛型接口，有两个参数：仓库操作的领域对象类型，及其ID属性的
 * 类型。此外，我还增加了一个findByReader()方法，可以根据读者的用户名来查找阅读列表。
 * 如果你好奇谁来实现这个ReadingListRepository及其继承的18个方法，请不用担心，
 * Spring Data提供了很神奇的魔法，只需定义仓库接口，在应用程序启动后，该接口在运行时会自
 * 动实现
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
