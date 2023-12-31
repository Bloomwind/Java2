// 初始化数组
for (int i = 0; i < n; i++) {
    queue[i] = i + 1;
}
// 处理每次移动命令
for (int i = 0; i < m; i++) {
    studentNumber 学生学号;
    moveDistance 移动距离;
    // 寻找被移动学生的当前位置
    currentPosition = findPosition(queue, studentNumber);
    // 计算新位置
    newPosition = currentPosition + moveDistance;
    // 更新数组
    if (currentPosition < newPosition) {// 学生向后移动
        for (int j = currentPosition; j < newPosition; j++) {
            queue[j] = queue[j + 1];
        }
    } else {// 学生向前移动
        for (int j = currentPosition; j > newPosition; j--) {
            queue[j] = queue[j - 1];
        }
    }
    queue[newPosition] = studentNumber;
}
