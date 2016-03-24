for i in 0..0
  test_case = Array.new
  String(gets).split(' ').each_slice(3).to_a.each do |slice|
    test_case.push({:win => slice[0].to_i, :draw => slice[1].to_i, :lose => slice[2].to_i})
  end

  while test_case.length != 0
    selected = test_case.select { |value| value[:win] == test_case.length - 1}
  end




end