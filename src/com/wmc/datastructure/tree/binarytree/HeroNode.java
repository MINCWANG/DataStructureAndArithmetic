package com.wmc.datastructure.tree.binarytree;

/**
 * @author: WangMC
 * @date: 2020/5/20 18:22
 * @description:
 */
public class HeroNode {
    private int no;
    private String name;
    //默认null
    private HeroNode left;

    //默认null
    private HeroNode right;


    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    public void delNodeAndReplaceRoot(int no) {

        //2. 如果当前结点的左子结点不为空，并且左子结点就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        if (this.getLeft() != null && this.getLeft().getNo() == no) {


            if (this.getLeft().getLeft() != null && this.getLeft().getRight() != null) {
                HeroNode tmp = this.getLeft().getRight();
                this.setRight(this.getLeft().getLeft());
                this.getLeft().setRight(tmp);
                return;
            }

            if (this.getLeft().getLeft() != null || this.getLeft().getRight() != null) {
                if (this.getLeft().getLeft() != null) {
                    this.setLeft(this.getLeft().getLeft());
                } else {
                    this.setLeft(this.getLeft().getRight());
                }
                return;
            }


        }
        // A B C 如下所shi
        //    A
        //   / \
        //   B  C
        //3.如果当前结点的右子结点不为空，并且右子结点就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if (this.getRight() != null && this.getRight().getNo() == no) {
            //对右子节点（A）的左叶子节点(B) 右叶子节点(C)进行判断，
            // 如果B,C都不为空，则将左叶子节点(B)代替右子节点(A),右叶子节点(C)不动
            if (this.getRight().getLeft() != null && this.getRight().getRight() != null) {
                // 将右叶子节点(C) 进行保存
                HeroNode tmp = this.getRight().getRight();
                // 将左叶子节点(B)代替右子节点(A)
                this.setRight(this.getRight().getLeft());
                // 将右叶子节点(C)添加到新右子节点(B)的右下
                this.getRight().setRight(tmp);
                return;
            }

            // 如果B,C其一不为空，则将左叶子节点(B)代替右子节点(A) 或者右叶子节点(C)代替右子节点(A)
            if (this.getRight().getLeft() != null || this.getRight().getRight() != null) {
                if (this.getRight().getLeft() != null) {
                    // //左叶子节点(B)代替右子节点(A)
                    this.setRight(this.getRight().getLeft());
                } else {
                    //右叶子节点(C)代替右子节点(A)
                    this.setRight(this.getRight().getRight());
                }
                return;
            }

        }
        //4.我们就需要向左子树进行递归删除
        if (this.getLeft() != null) {
            this.getLeft().delNode(no);
        }
        //5.则应当向右子树进行递归删除
        if (this.getRight() != null) {
            this.getRight().delNode(no);
        }


    }

    //递归删除结点
    //1.如果删除的节点是叶子节点，则删除该节点
    //2.如果删除的节点是非叶子节点，则删除该子树
    public void delNode(int no) {

        //2. 如果当前结点的左子结点不为空，并且左子结点就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        if (this.getLeft() != null && this.getLeft().getNo() == no) {
            this.setLeft(null);
            return;
        }
        //3.如果当前结点的右子结点不为空，并且右子结点就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if (this.getRight() != null && this.getRight().getNo() == no) {
            this.setRight(null);
            return;
        }
        //4.我们就需要向左子树进行递归删除
        if (this.getLeft() != null) {
            this.getLeft().delNode(no);
        }
        //5.则应当向右子树进行递归删除
        if (this.getRight() != null) {
            this.getRight().delNode(no);
        }


    }


    /**
     * 前序遍历查找
     *
     * @param no 查找no
     * @return 如果找到就返回该Node ,如果没有找到返回null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.getLeft() != null) {
            resNode = this.getLeft().preOrderSearch(no);
        }

        if (resNode != null) {//说明我们左子树找到
            return resNode;
        }

        if (this.getRight() != null) {
            resNode = this.getRight().preOrderSearch(no);
        }

        return resNode;


    }

    /**
     * 中序遍历查找
     *
     * @param no 查找no
     * @return 如果找到就返回该Node ,如果没有找到返回null
     */
    public HeroNode infixOrderSearch(int no) {

        HeroNode resNode = null;
        if (this.getLeft() != null) {
            resNode = this.getLeft().infixOrderSearch(no);
        }

        if (resNode != null) {//说明我们左子树找到
            return resNode;
        }
        System.out.println("进入中序遍历");
        if (this.no == no) {
            return this;
        }


        if (this.getRight() != null) {
            resNode = this.getRight().infixOrderSearch(no);
        }

        return resNode;


    }


    /**
     * 后序遍历查找
     *
     * @param no 查找no
     * @return 如果找到就返回该Node ,如果没有找到返回null
     */
    public HeroNode postOrderSearch(int no) {

        HeroNode resNode = null;
        if (this.getLeft() != null) {
            resNode = this.getLeft().postOrderSearch(no);
        }


        if (resNode != null) {
            return resNode;
        }

        if (this.getRight() != null) {
            resNode = this.getRight().postOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        System.out.println("进入后序遍历");
        if (this.no == no) {
            return this;
        }

        return resNode;
    }

    /**
     * 前序
     */
    public void preOrder() {
        System.out.println(this);
        //递归左子树
        if (this.left != null) {
            this.left.preOrder();
        }

        //递归右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序
     */
    public void infixOrder() {

        //递归左子树
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        //递归右子树
        if (this.right != null) {
            this.right.infixOrder();
        }
    }


    /**
     * 后续
     */
    public void postOrder() {
        //递归左子树
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归右子树
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
}
