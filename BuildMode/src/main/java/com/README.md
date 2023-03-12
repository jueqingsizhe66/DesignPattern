建造者模式的一般结构：

建造者不同于抽象工厂模式，抽象工厂模式更像是零部件厂家的生产工厂，从风机角度出来，他就是叶片、主轴承、齿轮箱、发电机、PLC等生产厂家
而建造者就是主机厂家，他负责把这些大型零部件进行组装。
Builder: 制定所有主机厂家的一般建设逻辑，比如先组装齿轮箱、主轴承、发电机、叶片等 但是都不是具体的过程