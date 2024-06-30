package qj

import (
	"sort"
)

func merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	var key [][]int
	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] <= intervals[i-1][1] {
			intervals[i][0] = intervals[i-1][0]
			if intervals[i][1] < intervals[i-1][1] {
				intervals[i][1] = intervals[i-1][1]
			}
		} else {
			key = append(key, intervals[i-1])
		}
	}
	key = append(key, intervals[len(intervals)-1])
	return key
}
