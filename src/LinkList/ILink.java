package LinkList;

public interface ILink<E> {    ////设置泛型避免安全隐患
    public void add(E e);     ///增加数据
    public int size();        ///保存的数据个数
    public boolean isEmpty();  ///判断数据集合是否为空
    public Object[] toArray();  ///将集合元素以数组的形式返回
    public E get(int index);    ////获取指定元素
    public void setNode(int index, E data);  /// 修改指定元素
    public boolean contains(E data);   ///判断节点是否存在
    public void remove(E data);  ////删除节点
    public void clean();  ///清空数据
}
